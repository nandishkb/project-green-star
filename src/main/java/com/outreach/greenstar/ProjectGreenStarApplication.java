package com.outreach.greenstar;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.outreach.greenstar.entities.Privilages;
import com.outreach.greenstar.entities.Role;
import com.outreach.greenstar.repository.PrivilagesRepository;
import com.outreach.greenstar.repository.RolesRepository;
import com.outreach.greenstar.utility.PrivilageEnum;

@SpringBootApplication
public class ProjectGreenStarApplication {

    @Autowired
    private RolesRepository rolesRepository;
    
    @Autowired
    private PrivilagesRepository privilagesRepository;
    
	public static void main(String[] args) {
		SpringApplication.run(ProjectGreenStarApplication.class, args);
	}
	
	@Bean
    public WebMvcConfigurer corsConfigurer() {
	    
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/api/v1/**").allowedOrigins("*").allowedMethods("*");
            }
        };
    }
	
	@Bean
	InitializingBean sendDatabase() {
	    return () -> {
	        createPrivilages();
	        createAdminRole();
	      };
	   }

    private void createAdminRole() {
        Optional<Role> rolesOp = rolesRepository.findById(1);
        if (!rolesOp.isPresent()) {
            Role roles = new Role();
            roles.setId(1);
            Optional<Privilages> opPriv = privilagesRepository.findById(PrivilageEnum.ALL.getId());
            List<Privilages> listOfPriv = new ArrayList<>();
            listOfPriv.add(opPriv.get());
            roles.setListOfPrivilages(listOfPriv);
            roles.setPwd("password");
            roles.setRoleName("admin");
            rolesRepository.saveAndFlush(roles);
        }
    }

    private void createPrivilages() {
        PrivilageEnum[] values = PrivilageEnum.values();
        Optional<Privilages> findById = privilagesRepository.findById(values[0].getId());
        if (findById.isPresent()) {
            return;
        }
        for (int i = 0; i < values.length; i++) {
            Privilages priv = new Privilages();
            priv.setId(values[i].getId());
            priv.setTitle(values[i].name());
            privilagesRepository.saveAndFlush(priv);
        }
    }

}

