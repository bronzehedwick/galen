package net.mindengine.galen.page.selenium;

import java.util.List;

import net.mindengine.galen.page.PageElement;
import net.mindengine.galen.page.Rect;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class ViewportElement implements PageElement {

    private WebDriver driver;

    public ViewportElement(WebDriver driver) {
        this.driver = driver;
    }

    @SuppressWarnings("unchecked")
    @Override
    public Rect getArea() {
        List<Long> size = (List<Long>)((JavascriptExecutor)driver).executeScript("return [window.innerWidth" +
                    "|| document.documentElement.clientWidth" + 
                    "|| document.body.clientWidth," +
                    "window.innerHeight" +
                    "|| document.documentElement.clientHeight" +
                    "|| document.body.clientHeight];"
                );
        return new Rect(0, 0, size.get(0).intValue(), size.get(1).intValue());
    }

    @Override
    public boolean isPresent() {
        return true;
    }

    @Override
    public boolean isVisible() {
        return true;
    }

    @Override
    public int getWidth() {
        return getArea().getWidth();
    }

    @Override
    public int getHeight() {
        return getArea().getHeight();
    }

    @Override
    public int getLeft() {
        return 0;
    }

    @Override
    public int getTop() {
        return 0;
    }

    @Override
    public String getText() {
        return "";
    }

}