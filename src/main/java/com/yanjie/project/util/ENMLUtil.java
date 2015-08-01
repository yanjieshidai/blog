package com.yanjie.project.util;

import com.evernote.edam.type.Note;
import com.syncthemall.enml4j.ENMLProcessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.stream.XMLStreamException;
import java.io.FileOutputStream;

/**
 * Description: ENMLUtil
 * Author: wangjie12
 * Create: 2015-08-01
 */
public class ENMLUtil {

    private static ThreadLocal<ENMLProcessor> tl = new ThreadLocal<>();
    private final static Logger logger = LoggerFactory.getLogger(ENMLUtil.class);

    public static String process(Note note) {
        ENMLProcessor processor = getProcessor();
        try {
            String context = processor.noteToInlineHTMLString(note);
            return context;
        } catch (XMLStreamException e) {
            logger.warn("解析出错", e);
            return null;
        }
    }


    public static ENMLProcessor getProcessor() {
        ENMLProcessor processor = tl.get();
        if (processor == null) {
            processor = new ENMLProcessor();
            tl.set(processor);
        }
        return processor;
    }
}
