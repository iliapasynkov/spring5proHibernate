/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.protechnologies.spring5prohibernate;

import java.util.List;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import ru.protechnologies.spring5prohibernate.config.AppConfig;
import ru.protechnologies.spring5prohibernate.dao.SingerDao;
import ru.protechnologies.spring5prohibernate.entities.Album;
import ru.protechnologies.spring5prohibernate.entities.Instrument;
import ru.protechnologies.spring5prohibernate.entities.Singer;

/**
 *
 * @author hitman
 */
public class SpringHibernateDemo {

    public static void main(String... args) {
        GenericApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        SingerDao singerDao = ctx.getBean(SingerDao.class);
        //singerDao.delete(singer);
        listSingers(singerDao.findAll());
        listSingersWithAlbum(singerDao.findAllWithAlbum());
        Singer singer = singerDao.findById(2l);
        System.out.println(singer.toString());
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
