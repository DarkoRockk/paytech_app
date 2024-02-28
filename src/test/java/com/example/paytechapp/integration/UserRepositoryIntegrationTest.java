package com.example.paytechapp.integration;

import com.example.paytechapp.entity.UserEntity;
import com.example.paytechapp.enums.Role;
import com.example.paytechapp.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigInteger;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryIntegrationTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void whenFindByName_thenReturnUserEntity() {
        UserEntity bob = createTestUser("bobby@gmail.com");
        entityManager.persistAndFlush(bob);

        UserEntity found = userRepository.findByEmail(bob.getEmail());
        assertThat(found.getEmail()).isEqualTo(bob.getEmail());
    }

    @Test
    public void whenInvalidEmail_thenReturnNull() {
        UserEntity fromDb = userRepository.findByEmail("doesNotExist");
        assertThat(fromDb).isNull();
    }

    @Test
    public void whenFindById_thenReturnUserEntity() {
        UserEntity emp = createTestUser("bob@gmail.com");
        entityManager.persistAndFlush(emp);

        UserEntity fromDb = userRepository.findById(emp.getId()).orElse(null);
        assertThat(fromDb.getEmail()).isEqualTo(emp.getEmail());
    }

    @Test
    public void whenInvalidId_thenReturnNull() {
        UserEntity fromDb = userRepository.findById(BigInteger.valueOf(-11)).orElse(null);
        assertThat(fromDb).isNull();
    }

    @Test
    public void givenSetOfUserEntities_whenFindAll_thenReturnAllUserEntities() {
        UserEntity alex = createTestUser("alex@alex.com");
        UserEntity ron = createTestUser("ron@ron.com");
        UserEntity bob = createTestUser("bob@bob.com");

        entityManager.persist(alex);
        entityManager.persist(bob);
        entityManager.persist(ron);
        entityManager.flush();

        List<UserEntity> allEmployees = userRepository.findAll();

        assertThat(allEmployees).hasSize(3).extracting(UserEntity::getEmail).containsOnly(alex.getEmail(), ron.getEmail(), bob.getEmail());
    }

    private UserEntity createTestUser(String email) {
        return UserEntity.builder()
                .firstName("Bob")
                .lastName("Smith")
                .username(email)
                .email(email)
                .role(Role.ROLE_USER)
                .password("123")
                .build();
    }


}
