package com.twoguysonepanda.itfest2018.controller;

import com.twoguysonepanda.itfest2018.entities.User;
import com.twoguysonepanda.itfest2018.service.UserService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.apache.commons.io.IOUtils;
import org.glassfish.jersey.media.multipart.FormDataParam;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(path = "/addAnalyse", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public @ResponseBody
    Boolean addAnalyse(
            @RequestParam(required = true) String email,
            @RequestParam(required = true) @DateTimeFormat(pattern = "yyyy-MM-dd") Date donationDate,
            @RequestBody() MultipartFile analyse
    ) throws IOException {
        return userService.addAnalyse(email, donationDate, analyse.getBytes());
    }



    @GetMapping(path = "/donors")
    public @ResponseBody
    List<User> donors ()
    {
        return userService.donors();
    }
}
