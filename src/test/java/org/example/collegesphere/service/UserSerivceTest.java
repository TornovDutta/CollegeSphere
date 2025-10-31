package org.example.collegesphere.service;

import org.example.collegesphere.exception.UserNotFoundException;
import org.example.collegesphere.model.Users;
import org.example.collegesphere.repo.UserRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@ExtendWith(MockitoExtension.class)
class UserSerivceTest {
    @InjectMocks
    private UserSerivce serivce;

    @Mock
    private UserRepo repo;

    @Test
    public void getTests(){
        List<Users> users=new ArrayList<>(
               List.of( new Users(1,"Tornov","bdfvjh","tornovdutta@Gmail.com","STUDENT",12))
        );
        Mockito.when(repo.findAll()).thenReturn(users);

        List<Users> returnAns=serivce.get();

        Assertions.assertEquals(users,returnAns);
    }
    @Test
    public void getIDTests() throws UserNotFoundException {
        Integer id=1;
        Users user=new Users(1,"Tornov","bdfvjh","tornovdutta@Gmail.com","STUDENT",12);

        Mockito.when(repo.findById(id)).thenReturn(Optional.of(user));
        Users returnAns=serivce.getID(id);

        Assertions.assertEquals(user,returnAns);

    }
    @Test
    public void addTest(){
        Users users=new Users(1,"Tornov","bdfvjh","tornovdutta@Gmail.com","STUDENT",21);
        Mockito.when(repo.save(users)).thenReturn(users);

        Integer id=serivce.add(users);

        Assertions.assertEquals(id,users.getId());
    }
    @Test
    public void testUpdate_Success() throws UserNotFoundException {
        int id = 1;
        Users existingUser = new Users(1, "Tornov", "123", "tornov@gmail.com", "STUDENT",23);
        Users updatedUser = new Users(1, "Tornov Dutta", "456", "tornov@gmail.com", "ADMIN",21);

        Mockito.when(repo.findById(id)).thenReturn(Optional.of(existingUser));
        Mockito.when(repo.save(existingUser)).thenReturn(updatedUser);

        Integer result = serivce.update(id, updatedUser);

        Assertions.assertEquals(1, result);

    }

    @Test
    public void testUpdate_UserNotFound() {
        int id = 2;
        Users newUser = new Users(2, "Unknown", "000", "unknown@gmail.com", "STUDENT",34);

        Mockito.when(repo.findById(id)).thenReturn(Optional.empty());

        Assertions.assertThrows(UserNotFoundException.class, () -> {
            serivce.update(id, newUser);
        });


    }
    @Test
    public void testDelete_Success() throws  UserNotFoundException{
        int id=1;
        Users users=new Users(1,"Tornov","1234","abc@gamil.com","STUDENT",12);
        Mockito.when(repo.findById(id)).thenReturn(Optional.of(users));
        serivce.delete(id);
        Mockito.verify(repo,Mockito.times(1)).removeById(id);
    }

}