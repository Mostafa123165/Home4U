package com.service.useManagement.repository;

import com.service.common.model.City;
import com.service.common.model.Governorate;
import com.service.common.service.CamelCaseGenerator;
import com.service.userManagement.model.User;
import com.service.userManagement.model.UserType;
import com.service.userManagement.repository.UserReps;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@DisplayNameGeneration(CamelCaseGenerator.class)
public class UserRepsTest {

    @Autowired
    UserReps userReps;

    User user;

    @BeforeEach
    void setup() {
        user = new User();
        Governorate governorate = new Governorate();
        City city = new City();
        UserType userType = new UserType();

        governorate.setId(1);
        city.setId(1);
        userType.setId(1);

        user.setFirstName("Mostafa");
        user.setLastName("Tarek");
        user.setEmail("test@gmail.com");
        user.setPassword("password");
        user.setPhone("01651562260");
        user.setCreatedDate(LocalDateTime.now());
        user.setModifiedDate(LocalDateTime.now());
        user.setCity(city);
        user.setGovernorate(governorate);
        user.setUserType(userType);
    }

    @Test
    @Transactional
    @Rollback
    @Order(1)
    void insertUser() {
        userReps.save(user);
        assertAll(() -> assertNotNull(user.getId()),
                ()-> assertEquals("test@gmail.com",user.getEmail()),
                ()-> assertEquals("Mostafa",user.getFirstName())
        );
    }

    @Test
    @Order(2)
    void findByEmail() {
        assertAll(
                ()-> assertNotNull(userReps.findByEmail("mostafa@gmail.com")),
                ()-> assertEquals(Optional.empty() ,userReps.findByEmail("132mostafa133@g"))
        );
    }

    @Test
    @Order(3)
    void findByPhone() {
        assertAll(
                ()-> assertNotNull(userReps.findByPhone("01061082296")),
                ()-> assertNotNull(userReps.findByPhone("01061082296"))
        );
    }

}
