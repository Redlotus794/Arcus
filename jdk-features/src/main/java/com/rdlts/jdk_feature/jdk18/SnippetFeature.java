package com.rdlts.jdk_feature.jdk18;

public class SnippetFeature {

    /**
     * This class provides utility methods for string operations.
     *
     * <p>Example usage:</p>
     * {@snippet :
     *   String result = StringUtils.capitalize("hello");  // Returns "Hello"
     *   boolean isEmpty = StringUtils.isBlank(" ");       // Returns true
     * }
     */
    public static void demo() {
        // see doc
        // 类省略实现
    }

    /**
     * Example of snippet with highlighting:
     * {@snippet :
     *   // @highlight region="important"
     *   String encoded = Base64.getEncoder().encodeToString(data);
     *   // @end
     *
     *   // @highlight regex="data" type="bold"
     *   byte[] decoded = Base64.getDecoder().decode(encoded);
     *
     *   // @replace regex="badPractice()" replacement="goodPractice()" type="error"
     *   result = badPractice();
     * }
     */
    public void example2() {
        // 方法省略实现
    }

    public static void main(String[] args) {

    }
}
