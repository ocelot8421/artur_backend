package com.artur.intakes.service;

import com.artur.intakes.dto.ConnectionDTO;
import com.artur.intakes.entity.DayOfWeek;
import com.artur.intakes.repositories.DayOfWeekRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DayOfWeekService {

    @Autowired
    private DayOfWeekRepository dayOfWeekRepository;

    public DayOfWeekService(DayOfWeekRepository dayOfWeekRepository) {
        this.dayOfWeekRepository = dayOfWeekRepository;
    }

    public DayOfWeek retrieveDayOfWeek (ConnectionDTO connection) {
        DayOfWeek dayOfWeek = new DayOfWeek();
        dayOfWeek.setId(connection.getDayOfWeek());

//        for (DayOfWeek dayOW : dayOfWeekRepository.findAll()) {
//            System.out.println("dayOW:");
//            System.out.println(dayOW.getId());
//            System.out.println(dayOW.getDayEng());
//        }

//        System.out.println(dayOfWeekRepository.getById(connection.getDayOfWeek()).getId());
//        System.out.println(dayOfWeekRepository.getById(connection.getDayOfWeek()).getDayEng());

        return dayOfWeek;
    }
}


