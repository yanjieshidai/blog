package com.yanjie.project.blog.service;

import com.evernote.auth.EvernoteAuth;
import com.evernote.auth.EvernoteService;
import com.evernote.clients.ClientFactory;
import com.evernote.clients.NoteStoreClient;
import com.evernote.edam.error.EDAMNotFoundException;
import com.evernote.edam.error.EDAMSystemException;
import com.evernote.edam.error.EDAMUserException;
import com.evernote.edam.notestore.NoteFilter;
import com.evernote.edam.notestore.NoteList;
import com.evernote.edam.type.Note;
import com.evernote.edam.type.Notebook;
import com.evernote.thrift.TException;
import com.yanjie.project.blog.Application;
import com.yanjie.project.util.ENMLUtil;
import org.junit.runner.RunWith;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

/**
 * Description: Test
 * Author: wangjie12
 * Create: 2015-08-01
 */
@RunWith(SpringJUnit4ClassRunner.class)   // 1
@SpringApplicationConfiguration(classes = Application.class)   // 2
@WebAppConfiguration   // 3
@IntegrationTest("server.port:0")   // 4
public class Test {

    @org.junit.Test
    public void testEvernote() throws TException, EDAMUserException, EDAMSystemException, EDAMNotFoundException {

//        "token": "S=s24:U=4d1488:E=154bf4042dd:C=14d678f15a0:P=1cd:A=en-devtoken:V=2:H=149cabbfcb8dff5daa056abd5d1e1974"
//        String developerToken = "S=s24:U=4d1488:E=154bf4042dd:C=14d678f15a0:P=1cd:A=en-devtoken:V=2:H=149cabbfcb8dff5daa056abd5d1e1974";
        String developerToken = "S=s1:U=90613:E=1563fdbaee0:C=14ee82a7f00:P=1cd:A=en-devtoken:V=2:H=94bf91cadf321439b17908e364c2bc02";

        // Set up the NoteStore client
        EvernoteAuth evernoteAuth = new EvernoteAuth(EvernoteService.SANDBOX, developerToken);
//        EvernoteAuth evernoteAuth = new EvernoteAuth(EvernoteService.YINXIANG, developerToken);
        ClientFactory factory = new ClientFactory(evernoteAuth);
        NoteStoreClient noteStore = factory.createNoteStoreClient();

        // Make API calls, passing the developer token as the authenticationToken param
        List<Notebook> notebooks = noteStore.listNotebooks();

        for (Notebook notebook : notebooks) {
            System.out.println("Notebook: " + notebook.getName());
        }
        NoteFilter noteFilter = new NoteFilter();
        NoteList notes = noteStore.findNotes(noteFilter, 0, 2);
        List<Note> list = notes.getNotes();
        System.out.println(list.size());
        for (Note note : list) {
            System.out.println(note.getTitle());
            String context = noteStore.getNoteContent(note.getGuid());
            note.setContent(context);
            System.out.println(context);
            System.out.println("----------------------------------------------------------");
            context = ENMLUtil.process(note);
            System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
            System.out.println(context);

        }

    }

}
