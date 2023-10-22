package com.gridnine.testing.service;

import com.gridnine.testing.model.Flight;

import java.util.List;

public class InfoService {
    public static void printInfo(List<Flight> flights) {
        System.out.println("Список полетов:\n");

        for (Flight flight : flights) {
            System.out.println(flight);
            System.out.println("-----");
        }

        System.out.println("Введите цифру для фильтра");
        System.out.println("(1) Вылет до текущего момента времени.");
        System.out.println("(2) Перелеты с сегментами с датой прилета раньше даты вылета.");
        System.out.println("(3) Перелеты с общим временем проведенным на земле более двух часов.");
        System.out.println("(0) Выйти");
    }
}
