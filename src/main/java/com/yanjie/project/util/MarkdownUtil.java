package com.yanjie.project.util;

import org.markdown4j.Markdown4jProcessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * Description: MarkdownUtil
 * Author: wangjie12
 * Create: 2015-08-01
 */
public class MarkdownUtil {

    private static ThreadLocal<Markdown4jProcessor> tl = new ThreadLocal<>();
    private final static Logger logger = LoggerFactory.getLogger(MarkdownUtil.class);

    public static String process(String md) {
        Markdown4jProcessor processor = getMarkdown4jProcessor();
        try {
            return processor.process(md);
        } catch (IOException e) {
            logger.warn("markdown解析出错。" + md);
            return null;
        }
    }

    /**
     * 线程安全
     *
     * @return
     */
    private static Markdown4jProcessor getMarkdown4jProcessor() {
        Markdown4jProcessor processor = tl.get();
        if (processor == null) {
            processor = new Markdown4jProcessor();
            tl.set(processor);
        }
        return processor;
    }
}
