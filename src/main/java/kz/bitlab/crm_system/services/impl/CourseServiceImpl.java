package kz.bitlab.crm_system.services.impl;

import kz.bitlab.crm_system.models.CourseModel;
import kz.bitlab.crm_system.repositories.CourseRepository;
import kz.bitlab.crm_system.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired CourseRepository courseRepository;

    public List<CourseModel> getAllCourseModel() {
        return courseRepository.findAll();
    }
}
