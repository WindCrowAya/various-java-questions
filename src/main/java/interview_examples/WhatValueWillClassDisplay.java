package interview_examples;

/**
 * Возникнет StackOverflowError из-за рекурсивной инициализации объектов под первой ссылкой ref
 * */
public class WhatValueWillClassDisplay {

    WhatValueWillClassDisplay ref = new WhatValueWillClassDisplay();

    public int show() {
        return true ? null : 0;
    }

    public static void main(String[] args) {
        WhatValueWillClassDisplay ref = new WhatValueWillClassDisplay();
        ref.show();
    }
}
