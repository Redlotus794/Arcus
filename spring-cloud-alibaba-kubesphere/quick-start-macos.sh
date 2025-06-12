#!/bin/bash

# 颜色定义
GREEN='\033[0;32m'
RED='\033[0;31m'
NC='\033[0m' # 无颜色

# 检查kubectl命令是否存在
check_kubectl() {
    if ! command -v kubectl &> /dev/null; then
        echo -e "${RED}错误: kubectl命令未找到${NC}"
        echo -e "${RED}请先安装kubectl: https://kubernetes.io/docs/tasks/tools/install-kubectl/ ${NC}"
        exit 1
    fi
    echo -e "${GREEN}kubectl命令已找到${NC}"
}

# 初始化Nacos服务
init_nacos() {
    echo -e "${GREEN}正在初始化Nacos服务...${NC}"
    kubectl apply -f k8s/nacos/nacos-arcus.yaml
    kubectl apply -f k8s/nacos/nacos-arcus-nodeport.yaml
    echo -e "${GREEN}Nacos服务初始化完成${NC}"
}

# 删除Nacos服务
delete_nacos() {
    echo -e "${GREEN}正在删除Nacos服务...${NC}"
    kubectl delete -f k8s/nacos/nacos-arcus-nodeport.yaml
    kubectl delete -f k8s/nacos/nacos-arcus.yaml
    echo -e "${GREEN}Nacos服务删除完成${NC}"
}

# 显示使用帮助
show_help() {
    echo "用法: $0 [选项]"
    echo "选项:"
    echo "  delete    删除Nacos服务"
    echo "  help      显示此帮助信息"
    echo ""
    echo "默认行为: 初始化Nacos服务"
}

# 主函数
main() {
    check_kubectl

    # 检查参数
    if [ $# -eq 0 ]; then
        init_nacos
    else
        case "$1" in
            delete)
                delete_nacos
                ;;
            help|--help|-h)
                show_help
                ;;
            *)
                echo -e "${RED}未知参数: $1${NC}"
                show_help
                exit 1
                ;;
        esac
    fi
}

# 执行主函数
main "$@"