import com.microsoft.sqlserver.jdbc.SQLServerException;
import org.junit.jupiter.api.Test;

import java.sql.Date;

import static org.junit.jupiter.api.Assertions.*;

class ArticleDAOImplTest {
    ArticleDAO articleDAO = new ArticleDAOImpl();
    @Test
    void getRecentArticle() throws Exception {
        assertEquals(3,articleDAO.getRecentArticle(3).size());
        ArticleEntity article = new ArticleEntity(1,
                "Making security feeds smarter via machine learning",
                "image/i1.jpg",
                "IN today’s age of surveillance, with cameras even in our homes, security professionals need to monitor an ever-increasing number of screens. In 2014 alone, 245 million video surveillance cameras were installed globally, according to an IHS report.\n" +
                        " \n" +
                        "It is increasingly clear that the ‘watchmen’ are having trouble watching. This is where Singapore-based Vi Dimensions hopes to help, by identifying anomalies to alert human operators that a second look is needed.\n" +
                        " \n" +
                        "While the security industry is already familiar with rule-based analytics, there is still a gap, according to its cofounder and chief executive officer Raymond Looi.\n" +
                        " \n" +
                        "“Video analytics has been in the market for the last 10 years, but the way they have been doing it is not very efficient, using rule-based analytics.\n" +
                        " \n" +
                        "“This requires you to know what you are looking for and then specify a rule, when most do not know what to look out for,” he says, in a conversation with Digital News Asia (DNA) in Singapore recently.\n" +
                        " \n" +
                        "“We felt that there was a gap in the industry in how they applied automation to cameras – and with the proliferation of surveillance cameras and vast amounts of data being generated, we felt that this was an area in which we could differentiate ourselves,” he adds."
                ,"Benjamin Cher",java.sql.Date.valueOf("2016-04-12"));
        assertAll("test id",
                () -> assertEquals(7,articleDAO.getRecentArticle(7).size()),
                () -> assertEquals(0,articleDAO.getRecentArticle(0).size()),
                () -> assertEquals(3,articleDAO.getRecentArticle(3).size()),
                () -> assertEquals(1,articleDAO.getRecentArticle(3).get(0).getId()),
                () -> assertEquals(2,articleDAO.getRecentArticle(3).get(1).getId()),
                () -> assertEquals(3,articleDAO.getRecentArticle(3).get(2).getId()));
        assertEquals(article.getImage(),articleDAO.getRecentArticle(3).get(0).getImage());
        assertThrows(SQLServerException.class,()->articleDAO.getRecentArticle(-1));

    }

    @Test
    void getArticleById() {
        assertAll("",
                ()-> assertEquals(1,articleDAO.getArticleById(1).getId()),
                ()-> assertEquals(3,articleDAO.getArticleById(3).getId()),
                ()-> assertEquals(7,articleDAO.getArticleById(7).getId())
                );
//        assertThrows(NullPointerException.class,()->articleDAO.getArticleById("").getId());
        assertThrows(NullPointerException.class,()->articleDAO.getArticleById(8).getId());
        assertThrows(NullPointerException.class,()->articleDAO.getArticleById(0).getId());
//        articleDAO.getArticleById(1.1);
    }

    @Test
    void searchByTitle() throws Exception {
        assertEquals(3,articleDAO.searchByTitle("ma",1,3).size());
        assertEquals(0,articleDAO.searchByTitle("ma",2,3).size());
        assertEquals(0,articleDAO.searchByTitle("test",1,3).size());
        assertEquals(3,articleDAO.searchByTitle("",1,3).size());
        assertEquals(3,articleDAO.searchByTitle("",2,3).size());
        assertEquals(1,articleDAO.searchByTitle("",3,3).size());
//        assertEquals(0,articleDAO.searchByTitle("",-1,3).size());
//        assertEquals(0,articleDAO.searchByTitle("",1,-1).size());
//        assertEquals(1,articleDAO.searchByTitle(213,1,3).size());
    }

    @Test
    void countArticle() throws Exception {
        assertEquals(3,articleDAO.countArticle("ma"));
        assertEquals(7,articleDAO.countArticle(""));
        assertEquals(1,articleDAO.countArticle("3"));
        assertEquals(0,articleDAO.countArticle("test"));
    }
}