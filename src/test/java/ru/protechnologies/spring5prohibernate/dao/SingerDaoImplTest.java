/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.protechnologies.spring5prohibernate.dao;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import ru.protechnologies.spring5prohibernate.config.AppConfig;
import ru.protechnologies.spring5prohibernate.entities.Album;
import ru.protechnologies.spring5prohibernate.entities.Instrument;
import ru.protechnologies.spring5prohibernate.entities.Singer;

/**
 *
 * @author hitman
 */
public class SingerDaoImplTest {

    private GenericApplicationContext ctx;
    private SingerDao singerDao;

    @Before
    public void setUp() {
        ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        singerDao = ctx.getBean(SingerDao.class);
        assertNotNull(singerDao);
    }

    @After
    public void tearDown() {
        ctx.close();
    }

    @Test
    public void testFindAll() {
        List<Singer> singers = singerDao.findAll();
        assertEquals(3, singers.size());
        listSingers(singers);
    }

    @Test
    public void testFindAllWithAlbum() {
        List<Singer> singers = singerDao.findAllWithAlbum();
        assertEquals(3, singers.size());
        listSingersWithAlbum(singers);
    }

    @Test
    public void testFindById() {
        Singer singer = singerDao.findById(1L);
        assertNotNull(singer);
        System.out.println(singer.toString());
    }

    @Test
    public void testSave() {
        Singer singer = new Singer();
        singer.setFirstName("BB");
        singer.setLastName("King");
        singer.setBirthDate(new Date(
                (new GregorianCalendar(1940, 8, 16)).getTime().getTime()));
        Album album = new Album();
        album.setTitle("My Kind of Blues");
        album.setReleaseDate(new java.sql.Date(
                (new GregorianCalendar(1961, 7, 18)).getTime().getTime()));
        singer.addAlbum(album);
        album = new Album();
        album.setTitle("A Heart Full of Blues");
        album.setReleaseDate(new java.sql.Date(
                (new GregorianCalendar(1962, 3, 20)).getTime().getTime()));
        singer.addAlbum(album);
        singerDao.save(singer);
        assertNotNull(singer.getId());
        List<Singer> singers = singerDao.findAllWithAlbum();
        assertEquals(4, singers.size());
        listSingersWithAlbum(singers);
    }

    @Test
    public void testUpdate() {
        Singer singer = singerDao.findById(1L);
        //making sure such singer exists
        assertNotNull(singer);
        //making sure we got expected singer
        assertEquals("Mayer", singer.getLastName());
        //retrieve the album
        Album album = singer.getAlbums().stream().filter(
                a -> a.getTitle().equals("Battle Studies")).findFirst().get();
        singer.setFirstName("John Clayton");
        singer.removeAlbum(album);
        singerDao.save(singer);
        // test the update
        listSingersWithAlbum(singerDao.findAllWithAlbum());
    }

    @Test
    public void testDelete() {
        Singer singer = singerDao.findById(2l);
        //making sure such singer exists
        assertNotNull(singer);
        singerDao.delete(singer);
        listSingersWithAlbum(singerDao.findAllWithAlbum());
    }

    private static void listSingers(List<Singer> singers) {
        for (Singer singer : singers) {
            System.out.println(singer.toString());
        }
    }

    private static void listSingersWithAlbum(List<Singer> singers) {
        System.out.println(" ---- Listing singers with instruments:");
        for (Singer singer : singers) {
            System.out.println(singer.toString());
            if (singer.getAlbums() != null) {
                for (Album album : singer.getAlbums()) {
                    System.out.println("\t" + album.toString());
                }
            }
            if (singer.getInstruments() != null) {
                for (Instrument instrument : singer.getInstruments()) {
                    System.out.println("\t" + instrument.getInstrumentId());
                }
            }
        }
    }
}
