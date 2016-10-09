package com.designPattern.patterns.templateMethod;

public abstract class TemplateClass {
    protected abstract void dosometing();

    protected abstract void doanyting();

    public void templateMethod() {
        dosometing();

        doanyting();
    }
}
