#!/bin/bash

#
# Description:
#   This script validates all Jenkins pipeline files (main.groovy) found in the projects directory.
#   It uses the Jenkins Pipeline Model Converter endpoint to perform the validation.
#
# Usage:
#   ./validate-pipeline.sh
#
# Requirements:
#   - curl
#   - A running Jenkins instance
#

# --- Configuration ---

# Set the URL of your Jenkins instance
JENKINS_URL="http://localhost:9090"

# Set Jenkins credentials if authentication is enabled
# To get an API token, go to Jenkins -> Your User -> Configure -> API Token
JENKINS_USER="arcus"
JENKINS_TOKEN="1137ef5942de803339275af691c3a779d4"

# --- Script ---

set -e
set -o pipefail

# The script is in arcus-pipeline/scripts, so projects are at ../projects
PROJECTS_DIR="../projects"

echo "Starting pipeline validation..."
echo "Jenkins URL: ${JENKINS_URL}"
echo "Projects directory: ${PROJECTS_DIR}"
echo "=================================================="

# Find all main.groovy files in the projects subdirectories
PIPELINE_FILES=$(find "${PROJECTS_DIR}" -type f -name "main.groovy")

if [ -z "${PIPELINE_FILES}" ]; then
    echo "No 'main.groovy' files found in '${PROJECTS_DIR}'."
    exit 1
fi

VALIDATION_HAS_FAILED=false

for file in ${PIPELINE_FILES}; do
    echo -n "Validating ${file}... "

    # Build the curl command
    CURL_CMD=(
        "curl"
        "--silent"
        "-X" "POST"
    )

    # Add authentication if user and token are set
    if [ -n "${JENKINS_USER}" ] && [ -n "${JENKINS_TOKEN}" ]; then
        CURL_CMD+=("-u" "${JENKINS_USER}:${JENKINS_TOKEN}")
    fi

    CURL_CMD+=("-F" "jenkinsfile=<${file}" "${JENKINS_URL}/pipeline-model-converter/validate")

    # Execute the validation command
    response=$("${CURL_CMD[@]}")

    # Check the response for errors
    if echo "${response}" | grep -q "Errors"; then
        echo "FAILED"
        echo "--------------------------------------------------"
        echo "Validation errors for ${file}:"
        echo "${response}"
        echo "--------------------------------------------------"
        VALIDATION_HAS_FAILED=true
    else
        echo "OK"
    fi
done

echo "=================================================="

if [ "${VALIDATION_HAS_FAILED}" = true ]; then
    echo "Pipeline validation finished with errors."
    exit 1
else
    echo "All pipeline files validated successfully."
    exit 0
fi

