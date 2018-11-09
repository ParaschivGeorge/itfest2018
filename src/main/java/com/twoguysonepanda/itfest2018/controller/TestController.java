package com.twoguysonepanda.itfest2018.controller;

import com.twoguysonepanda.itfest2018.entities.TestObject;
import com.twoguysonepanda.itfest2018.service.TestObjectService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.hateoas.PagedResources;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {

    private TestObjectService testObjectService;

    @GetMapping(path = "/test")
    public String GetTest(){
        return "Test";
    }

    @GetMapping(path = "to-name-and-mto-name")
    public @ResponseBody PagedResources<TestObject> hasNameLikeAndhasMiniObejctNameLike(
            @PageableDefault(page = 0, size = 10)Pageable pageable,
            @RequestParam(required = false) String TOname,
            @RequestParam(required = false) String MTOname) {
        return testObjectService.hasNameLikeAndhasMiniObejctNameLike(pageable, TOname, MTOname);
    }
}
