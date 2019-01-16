package com.muspro.app.dahira;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dahira")
public class DahiraController
{

    @Autowired
    DahiraInfoRepository dahiraInfoRepository;

    @GetMapping("/search")
    public ResponseEntity<List<DahiraResponse>> searchDahiraInfo()
    {
        List<DahiraResponse> allUsers = new ArrayList<>();

        Function<DahiraInfoEntity, DahiraResponse> createResponse = DahiraResponse::new;

        Consumer<List<DahiraInfoEntity>> createDahiraList = list -> list.stream()
                .forEach(dahiraInfoEntity -> allUsers.add(createResponse.apply(dahiraInfoEntity)));

        createDahiraList.accept(dahiraInfoRepository.findAll());

        return new ResponseEntity<List<DahiraResponse>>(allUsers, HttpStatus.OK);
    }

    @GetMapping("/search/{keyword}")
    public ResponseEntity<List<DahiraResponse>> searchDahiraInfo(@PathVariable("keyword") String keyword)
    {
        List<DahiraResponse> allUsers = new ArrayList<>();

        Function<DahiraInfoEntity, DahiraResponse> createResponse = DahiraResponse::new;

        Consumer<List<DahiraInfoEntity>> createDahiraList = list -> list.stream()
                .forEach(dahiraInfoEntity -> allUsers.add(createResponse.apply(dahiraInfoEntity)));

        createDahiraList.accept(dahiraInfoRepository
                .findByNameContainingOrLocationContainingOrAddressContainingOrJawrigneContainingOrPhoneContainingAllIgnoreCase(
                        keyword, keyword, keyword, keyword, keyword));

        return new ResponseEntity<List<DahiraResponse>>(allUsers, HttpStatus.OK);
    }

}
