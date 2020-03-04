package com.ws.exp.everything.classtest;

import sun.misc.Launcher;

/**
 * ClassLoader测试
 *
 * @author Eric at 2020-02-29_20:57
 */
public class ClassLoaderExp {
    public void printClassLoader() {
        ClassLoader loader = this.getClass().getClassLoader();
        do {
            System.out.println(loader);
            loader = loader.getParent();
        } while (loader != null);
    }

    // bootstrap classloader
    public void printBootstrapLoaderPath() {
        System.out.println(System.getProperty("sun.boot.class.path"));
    }

    public static void main(String[] args) {
        ClassLoaderExp exp = new ClassLoaderExp();
        // exp.printClassLoader();
        exp.printBootstrapLoaderPath();
    }
}
