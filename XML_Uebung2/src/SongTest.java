import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;


public class SongTest {

  private static final String MUSICSTREAM_XML = "./musicstream-jaxb.xml";

  public static void main(String[] args) throws JAXBException, IOException {

    ArrayList<Song> songlist = new ArrayList<Song>();

    //Songs zum testen werden generiert
    Song song1 = new Song();
    song1.setSongname("song1");
    song1.setSinger("singer1");
    song1.setAlbum("album1");
    song1.setLength(3);
    songlist.add(song1);

    Song song2 = new Song();
    song2.setSongname("song2");
    song2.setSinger("singer2");
    song2.setAlbum("album2");
    song2.setLength(3);
    songlist.add(song2);

    // MusicStream (Seiten) werden erstellt
    MusicStream mstream = new MusicStream();
    mstream.setName("Youtube");
    mstream.setSonglist(songlist);
  


    JAXBContext context = JAXBContext.newInstance(MusicStream.class);
    Marshaller m = context.createMarshaller();
    m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

    // Write to System.out
    m.marshal(mstream, System.out);

    // Write to File
    m.marshal(mstream, new File(MUSICSTREAM_XML));

    // get variables from our xml file, created before
    System.out.println();
    System.out.println("Output from our XML File: ");
    Unmarshaller um = context.createUnmarshaller();
    MusicStream mstream2 = (MusicStream) um.unmarshal(new FileReader(MUSICSTREAM_XML));
    ArrayList<Song> slist = mstream2.getSonglist();
    for (Song song : slist) {
      System.out.println("Song: " + song1.getSongname() + " from "
          + song1.getSinger());
    }
  }
} 