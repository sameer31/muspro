package com.muspro.adminpanel.admin;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.muspro.adminpanel.exception.ResourceNotFoundException;

@RestController
@RequestMapping("/admin")
public class AdminLoginController
{

    @Autowired
    private AdminCredentialsRepository adminCredentialsRepository;

    @PostMapping("/validateAdminLogin")
    public ResponseEntity<String> validateAdminLogin(@Valid @RequestBody AdminLoginRequest adminLoginRequest)
    {

        List<AdminCredentialsEntity> adminList = adminCredentialsRepository
                .fetchByUserName(adminLoginRequest.getUserName());

        if (adminList.size() == 0)
        {
            throw new ResourceNotFoundException("AdminCredentials", "UserName", adminLoginRequest.getUserName());
            /*return new ResponseEntity<String>(
                    "Admin Credentials not found with user name " + adminLoginRequest.getUserName(),
                    HttpStatus.NOT_FOUND);*/
        }
        
        AdminCredentialsEntity admin = adminList.get(0);
        
        if (admin.getPasswordHash().equals(adminLoginRequest.getPassword().concat(admin.getPasswordSalt())))
        {
            return new ResponseEntity<String>(String.valueOf(admin.getId()), HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<String>("Password did not match", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
