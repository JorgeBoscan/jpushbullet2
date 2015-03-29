package net.iharder;

import net.iharder.jpushbullet2.Contact;
import net.iharder.jpushbullet2.Device;
import net.iharder.jpushbullet2.PushbulletClient;
import net.iharder.jpushbullet2.PushbulletException;
import net.iharder.jpushbullet2.push.*;

import java.io.File;
import java.util.List;

public class Test {

    public static void main(String args[]) throws PushbulletException {
        PushbulletClient client = new PushbulletClient("v1WftnSWfoF68XiT1LFk8Sj7ncIryO2O8nujv6u7ZiELc");
        File file = new File("/home/jorge/Pictures/asepriteicon.jpg");
        List<Contact> contacts = client.getContacts();
        List<Device> devices = client.getDevices();

        for (Device device : devices) {
            SendPush notePush = new NotePush.NotePushBuilder()
                    .deviceIden(device.getIden())
                    .title("Title MEGA ULTRA AWESOMEFEST")
                    .body("UBER MEGA BODY FTY")
                    .create();
            String result = client.sendPush(notePush);
            System.out.println("result = " + result);
        }
        SendPush notePush = new NotePush.NotePushBuilder()
                .deviceIden(devices.get(0).getIden())
                .title("Title MEGA ULTRA AWESOMEFEST")
                .body("UBER MEGA BODY FTY")
                .create();
        SendPush linkPush = new LinkPush.LinkPushBuilder()
                .email(contacts.get(0).getEmail())
                .title("Google Search Engine")
                .body("Really nice search engine.")
                .url("http://www.google.com")
                .create();
        String result = client.sendPush(notePush);
        System.out.println("result = " + result);
        result = client.sendPush(linkPush);
        System.out.println("result = " + result);

        SendPush addressPush = new AddressPush.AddressPushBuilder()
                .email(contacts.get(0).getEmail())
                .name("Home")
                .address("Venezuela, Barquisimeto, Urb. El Pedregal I")
                .create();
        result = client.sendPush(addressPush);
        System.out.println("result = " + result);
        SendPush listPush = new ListPush.ListPushBuilder()
                .email(contacts.get(0).getEmail())
                .title("Prueba de Lista")
                .item("Item1")
                .item("Item2")
                .item("Item3")
                .create();
        result = client.sendPush(listPush);
        System.out.println("result = " + result);
        SendPush filePush = new FilePush.FilePushBuilder()
                .email(contacts.get(0).getEmail())
                .body("File test")
                .file(file)
                .create();
        result = client.sendPush(filePush);
        System.out.println("result = " + result);

//        client.sendLink(null, "Test Link", "http://www.google.com");
//        client.sendAddress(null, "Test Address", "Urb. El Pedregal I");
//        client.sendList(null, "Test List", "Item1", "Item2", "Item3");
//        client.sendFile(null, file, "Test file");
    }

}

