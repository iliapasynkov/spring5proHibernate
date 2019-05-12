/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.protechnologies.spring5prohibernate.dao;

import java.util.List;
import ru.protechnologies.spring5prohibernate.entities.Singer;

/**
 *
 * @author hitman
 */
public interface SingerDao {
    
    List<Singer> findAll();
    List<Singer> findAllWithAlbum();
    Singer findById(Long id);
    Singer save(Singer contact);
    void delete(Singer contact);
}
