package ru.netology.homework.manager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PosterManagerTest {

    @Test
    public void limitByDefault() {
        PosterManager posterManager = new PosterManager();
        posterManager.setLimit();
        int expected = 5;
        int actual = posterManager.getLimit();

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void setLimitP1() {
        PosterManager posterManager = new PosterManager(3);
        posterManager.setLimit();
        int expected = 3;
        int actual = posterManager.getLimit();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void setLimitP2() {
        PosterManager posterManager = new PosterManager(6);
        posterManager.setLimit();
        int expected = 6;
        int actual = posterManager.getLimit();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void addPosterTest() {
        PosterManager posterManager = new PosterManager();
        posterManager.setPosters(posterManager.getPosters());
        posterManager.addPoster("Бладшот");

        String[] expected = { "Бладшот" };
        String[] actual = posterManager.getPosters();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void findAllTest() {

        PosterManager posterManager = new PosterManager();
        posterManager.addPoster("Бладшот");
        posterManager.addPoster("Вперед");
        posterManager.addPoster("Отель Белград");
        posterManager.addPoster("Джентльмены");
        posterManager.addPoster("Человек-невидимка");
        posterManager.addPoster("Тролли. Мировой тур");
        posterManager.addPoster("Номер один");

        String[] expected = {
                "Бладшот",
                "Вперед",
                "Отель Белград",
                "Джентльмены",
                "Человек-невидимка",
                "Тролли. Мировой тур",
                "Номер один"
        };
        String[] actual = posterManager.findAll();

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void findLastForLimitByDefaultTest() {

        PosterManager posterManager = new PosterManager();
        posterManager.addPoster("Бладшот");
        posterManager.addPoster("Вперед");
        posterManager.addPoster("Отель Белград");
        posterManager.addPoster("Джентльмены");
        posterManager.addPoster("Человек-невидимка");
        posterManager.addPoster("Тролли. Мировой тур");
        posterManager.addPoster("Номер один");

        String[] expected = {
                "Номер один",
                "Тролли. Мировой тур",
                "Человек-невидимка",
                "Джентльмены",
                "Отель Белград",

        };
        String[] actual = posterManager.findLast();

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void findLastForSetLimitTest() {

        PosterManager posterManager = new PosterManager(7);
        posterManager.addPoster("Бладшот");
        posterManager.addPoster("Вперед");
        posterManager.addPoster("Отель Белград");
        posterManager.addPoster("Джентльмены");
        posterManager.addPoster("Человек-невидимка");
        posterManager.addPoster("Тролли. Мировой тур");
        posterManager.addPoster("Номер один");

        String[] expected = {
                "Номер один",
                "Тролли. Мировой тур",
                "Человек-невидимка",
                "Джентльмены",
                "Отель Белград",
                "Вперед",
                "Бладшот"

        };
        String[] actual = posterManager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }
}