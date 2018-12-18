package com.muspro.adminpanel.usermanagement.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.muspro.adminpanel.usermanagement.model.UserAccountEntity;
import com.muspro.adminpanel.usermanagement.model.UserDetails;
import com.muspro.adminpanel.usermanagement.repository.UserAccountRepository;
import com.muspro.adminpanel.usermanagement.repository.UserDetailsRepository;
import com.muspro.adminpanel.usermanagement.request.UserAccountRequest;
import com.muspro.adminpanel.usermanagement.response.UserAccountResponse;

@RestController
@RequestMapping("/userManagement")
public class UserManagementController
{

    @Autowired
    UserAccountRepository userAccountRepository;

    @Autowired
    UserDetailsRepository userDetailsRepository;

    @GetMapping("/allUsers")
    public ResponseEntity<List<UserAccountResponse>> getAllUsers()
    {
        List<UserAccountResponse> allUsers = new ArrayList<>();

        List<UserAccountEntity> allUserEntities = userAccountRepository.findAll();

        Function<UserAccountEntity, UserAccountResponse> createResponse = UserAccountResponse::new;
        
        Consumer<List<UserAccountEntity>> createResponseList = list -> list.stream()
                .forEach(userAccount -> allUsers.add(createResponse.apply(userAccount)));

        createResponseList.accept(allUserEntities);

        return new ResponseEntity<List<UserAccountResponse>>(allUsers, HttpStatus.OK);
    }

    @PostMapping("/createUserAccount")
    public UserAccountEntity createUserLogin(@Valid @RequestBody UserAccountRequest userAccountRequest)
    {
        UserDetails userDetails = new UserDetails();

        userDetails.setEmail(userAccountRequest.getEmail());
        userDetails.setFirstName(userAccountRequest.getFirstName());
        userDetails.setLastName(userAccountRequest.getLastName());
        userDetails.setPasswordSalt("password");
        userDetails.setPasswordHash("password");

        userDetails = userDetailsRepository.save(userDetails);

        UserAccountEntity userAccount = new UserAccountEntity();
        userAccount.setScreenUserName(userAccountRequest.getScreenUserName());
        userAccount.setUserDetails(userDetails);

        return userAccountRepository.save(userAccount);
    }

    // @GetMapping("/searchByEmail/{email}")
    // public List<UserLogin> searchByEmail(@PathVariable(value = "email") String emailId)
    // {
    // return userLoginRepository.searchByEmail(emailId);
    // }

    // @PutMapping("/notes/{id}")
    // public Note updateNote(@PathVariable(value = "id") Long noteId, @Valid @RequestBody Note noteDetails)
    // {
    //
    // Note note = noteRepository.findById(noteId)
    // .orElseThrow(() -> new ResourceNotFoundException("Note", "id", noteId));
    //
    // note.setTitle(noteDetails.getTitle());
    // note.setContent(noteDetails.getContent());
    //
    // Note updatedNote = noteRepository.save(note);
    // return updatedNote;
    // }
    //
    // @DeleteMapping("/email/{emailId}")
    // public ResponseEntity<?> deleteNote(@PathVariable(value = "emailId") String emailId)
    // {
    // List<UserLogin> users = userLoginRepository.searchByEmail(emailId);
    //
    // userLoginRepository.deleteAll(users);
    //
    // return ResponseEntity.ok().build();
    // }
}
