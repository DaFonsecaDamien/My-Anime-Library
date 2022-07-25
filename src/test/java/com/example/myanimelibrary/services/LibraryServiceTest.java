package com.example.myanimelibrary.services;

import com.example.myanimelibrary.configuration.ServicesTestConfiguration;
import com.example.myanimelibrary.domain.Library;
import com.example.myanimelibrary.domain.repositories.LibraryRepository;

import com.example.myanimelibrary.domain.service.LibraryService;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(SpringRunner.class)
public class LibraryServiceTest {

    @Autowired
    LibraryService libraryService;

    @MockBean
    private LibraryRepository libraryRepository;

    @BeforeAll
    public static void setUp(){

    }

    @Test
    public void should_return_a_library_when_get_library_by_id(){
        Library library = new Library();
        library.setId(1L);

        when(libraryRepository.getLibraryById(1L)).thenReturn(library);
        Library libraryFound = libraryService.getLibraryById(1L);

        Assert.assertNotNull(libraryFound);
        Assert.assertEquals(Long.valueOf(1L), libraryFound.getId());
    }

    @Test
    public void should_return_a_library_when_get_library_by_user_id(){
        Library library = new Library();
        library.setId(1L);

        when(libraryRepository.getLibraryByUserId(1L)).thenReturn(library);
        Library libraryFound = libraryService.getLibraryByUserId(1L);

        Assert.assertNotNull(libraryFound);
        Assert.assertEquals(Long.valueOf(1L), libraryFound.getId());
    }

}
