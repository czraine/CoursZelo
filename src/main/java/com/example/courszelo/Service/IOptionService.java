package com.example.courszelo.Service;

import com.example.courszelo.entity.Option;

import java.util.List;

public interface IOptionService {

    Option addModuleToOption(String optionId, String moduleId);
    public Option addOptionWithModules(Option option, List<String> moduleIds);
}
