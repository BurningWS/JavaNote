package service;

import domain.Footer;

public class FooterService {

    private static Footer f = new Footer();

    static {
        f.setDes("北京-廊坊-好公司呢！！！！哇哈哈！！！");
    }

    public static void update(String des) {
        f.setDes(des);
    }

    public static Footer gerFooter() {
        return f;
    }
}  