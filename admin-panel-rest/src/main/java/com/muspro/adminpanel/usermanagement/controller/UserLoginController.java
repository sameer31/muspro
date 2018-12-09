package com.muspro.adminpanel.usermanagement.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.muspro.adminpanel.usermanagement.model.UserAccount;
import com.muspro.adminpanel.usermanagement.model.UserDetails;
import com.muspro.adminpanel.usermanagement.repository.UserAccountRepository;
import com.muspro.adminpanel.usermanagement.repository.UserDetailsRepository;
import com.muspro.adminpanel.usermanagement.request.UserAccountRequest;

@RestController
@RequestMapping("/userManagement")
public class UserLoginController
{

    @Autowired
    UserAccountRepository userAccountRepository;
    
    @Autowired
    UserDetailsRepository userDetailsRepository;

    // @GetMapping("/allLogins")
    // public List<UserLogin> getAllLogins()
    // {
    // return userLoginRepository.findAll();
    // }

    @PostMapping("/createUserAccount")
    public UserAccount createUserLogin(@Valid @RequestBody UserAccountRequest userAccountRequest)
    {
        UserDetails userDetails = new UserDetails();

        userDetails.setEmail(userAccountRequest.getEmail());
        userDetails.setFirstName(userAccountRequest.getFirstName());
        userDetails.setLastName(userAccountRequest.getLastName());
        userDetails.setPasswordSalt("password");
        userDetails.setPasswordHash("password");
        
        userDetails = userDetailsRepository.save(userDetails);
        
        UserAccount userAccount = new UserAccount();
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
