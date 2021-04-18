import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ArticleEntityTest {

    @org.junit.jupiter.api.Test
    void testGetId() {
        ArticleEntity article = new ArticleEntity(1,"Covid 19","images/covid","new vaccine for corona virus","KhoiVT",
                new Date(System.currentTimeMillis()));
        assertEquals(1,article.getId());
        ArticleEntity article2 = new ArticleEntity();
        assertEquals(0,article2.getId());
    }

    @org.junit.jupiter.api.Test
    void testSetId() {
        ArticleEntity article = new ArticleEntity(1,"Covid 19","images/covid","new vaccine for corona virus","KhoiVT",
                new Date(System.currentTimeMillis()));
        article.setId(10);
        assertNotEquals(1,article.getId());
        assertEquals(10,article.getId());
        article.setId(-10);
        assertEquals(-10,article.getId());
//        article.setId("");
    }

    @org.junit.jupiter.api.Test
    void testGetTitle() {
        ArticleEntity article = new ArticleEntity(1,"Covid 19","images/covid","new vaccine for corona virus","KhoiVT",
                new Date(System.currentTimeMillis()));
        assertEquals("Covid 19",article.getTitle());
        ArticleEntity article2 = new ArticleEntity();
        assertEquals(null,article2.getTitle());
        ArticleEntity article3 = new ArticleEntity(0,"","","","",null);
        assertEquals("",article3.getTitle());
    }

    @org.junit.jupiter.api.Test
    void testSetTitle() {
        ArticleEntity article = new ArticleEntity(1,"Covid 19","images/covid","new vaccine for corona virus","KhoiVT",
                new Date(System.currentTimeMillis()));
        article.setTitle("Vaccine for Covid 19");
        assertNotEquals("Covid 19",article.getTitle());
        assertEquals("Vaccine for Covid 19",article.getTitle());
    }

    @org.junit.jupiter.api.Test
    void testGetImage() {
        ArticleEntity article = new ArticleEntity(1,"Covid 19","images/covid","new vaccine for corona virus","KhoiVT",
                new Date(System.currentTimeMillis()));
        assertEquals("images/covid",article.getImage());
        ArticleEntity article2 = new ArticleEntity();
        assertEquals(null,article2.getImage());
        ArticleEntity article3 = new ArticleEntity(0,"","","","",null);
        assertEquals("",article3.getImage());
    }

    @org.junit.jupiter.api.Test
    void testSetImage() {
        ArticleEntity article = new ArticleEntity(1,"Covid 19","images/covid","new vaccine for corona virus","KhoiVT",
                new Date(System.currentTimeMillis()));
        article.setImage("images/covid19");
        assertNotEquals("images/covid",article.getImage());
        assertEquals("images/covid19",article.getImage());
    }

    @org.junit.jupiter.api.Test
    void testGetContent() {
        ArticleEntity article = new ArticleEntity(1,"Covid 19","images/covid","new vaccine for corona virus","KhoiVT",
                new Date(System.currentTimeMillis()));
        assertEquals("new vaccine for corona virus",article.getContent());
        ArticleEntity article2 = new ArticleEntity();
        assertEquals(null,article2.getContent());
        ArticleEntity article3 = new ArticleEntity(0,"","","","",null);
        assertEquals("",article3.getContent());
    }

    @org.junit.jupiter.api.Test
    void testSetContent() {
        ArticleEntity article = new ArticleEntity(1,"Covid 19","images/covid","new vaccine for corona virus","KhoiVT",
                new Date(System.currentTimeMillis()));
        article.setContent("new vaccine is effective to kill 99% corona virus");
        assertNotEquals("new vaccine for corona virus",article.getContent());
        assertEquals("new vaccine is effective to kill 99% corona virus",article.getContent());
    }

    @org.junit.jupiter.api.Test
    void testGetAuthorName() {
        ArticleEntity article = new ArticleEntity(1,"Covid 19","images/covid","new vaccine for corona virus","KhoiVT",
                new Date(System.currentTimeMillis()));
        assertEquals("KhoiVT",article.getAuthorName());
        ArticleEntity article2 = new ArticleEntity();
        assertEquals(null,article2.getAuthorName());
        ArticleEntity article3 = new ArticleEntity(0,"","","","",null);
        assertEquals("",article3.getAuthorName());
    }

    @org.junit.jupiter.api.Test
    void testSetAuthorName() {
        ArticleEntity article = new ArticleEntity(1,"Covid 19","images/covid","new vaccine for corona virus","KhoiVT",
                new Date(System.currentTimeMillis()));
        article.setAuthorName("Vu Tien Khoi");
        assertNotEquals("KhoiVT",article.getAuthorName());
        assertEquals("Vu Tien Khoi",article.getAuthorName());
    }

    @org.junit.jupiter.api.Test
    void testGetDateCreated() {
        System.out.println(new Date(System.currentTimeMillis()));
        ArticleEntity article = new ArticleEntity(1,"Covid 19","images/covid","new vaccine for corona virus","KhoiVT",
                new Date(System.currentTimeMillis()));
        assertEquals(new Date(System.currentTimeMillis()),article.getDateCreated());
        ArticleEntity article2 = new ArticleEntity();
        assertEquals(null,article2.getDateCreated());
        //Datecreated: Jan 15 1970 - 09:57am
        ArticleEntity article3 = new ArticleEntity(0,"","","","",new Date(1220227200));
        assertEquals(new Date(1220227200),article3.getDateCreated());
    }

    @org.junit.jupiter.api.Test
    void testSetDateCreated() {
        ArticleEntity article = new ArticleEntity(1,"Covid 19","images/covid","new vaccine for corona virus","KhoiVT",
                new Date(System.currentTimeMillis()));
        article.setDateCreated(new Date(1220227200));// Jan 15 1970 - 09:57am
        assertEquals(new Date(1220227200),article.getDateCreated());
        assertNotEquals(new Date(System.currentTimeMillis()),article.getDateCreated());

    }

    @org.junit.jupiter.api.Test
    void getDateFormat() {
        ArticleEntity article = new ArticleEntity(1,"Covid 19","images/covid","new vaccine for corona virus","KhoiVT",
                new Date(System.currentTimeMillis()));
        assertEquals(article.getDateFormat(new Date(System.currentTimeMillis())),
                article.getDateFormat(article.getDateCreated()));
        System.out.println(article.getDateFormat(new Date(1220227200)));
        //Datecreated: Jan 15 1970 - 09:57am
        ArticleEntity article3 = new ArticleEntity(0,"","","","",new Date(1220227200));
        assertEquals(article3.getDateFormat(new Date(1220227200)),
                article3.getDateFormat(article3.getDateCreated()));
        assertThrows(NullPointerException.class,()->article.getDateFormat(null));
    }
}