package com.preschool.controller;

import com.preschool.dto.AdmissionDto;
import com.preschool.entity.Admission;
import com.preschool.entity.BotAttempt;
import com.preschool.repository.AdmissionRepository;
import com.preschool.repository.BotAttemptRepository;
import com.preschool.service.CaptchaService;

import jakarta.servlet.http.HttpServletRequest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AdmissionController {

    @Autowired
    private AdmissionRepository admissionRepository;

    @Autowired
    private BotAttemptRepository botAttemptRepository;

    @Autowired
    private CaptchaService captchaService;


    @GetMapping("/register")
    public String showRegisterPage(Model model) {

        model.addAttribute("admission", new AdmissionDto());

        return "register";
    }



    @PostMapping("/admission/submit")
    public String submitForm(
            @ModelAttribute AdmissionDto admissionDto,
            HttpServletRequest request){

        System.out.println("Captcha Token: " + admissionDto.getCaptcha());

        double score = captchaService.verifyCaptcha(admissionDto.getCaptcha());

        System.out.println("Captcha Score: " + score);
        
        
        if(admissionDto.getPreschooloratricskidzz()!=null && !admissionDto.getPreschooloratricskidzz().isEmpty()){

            System.out.println("Honeypot bot detected");

            return "redirect:/register";
        }else {
        	
        	 System.out.println("Honeypot  Not ...... bot detected");
        }

        if(score >= 0.7){

            System.out.println("Genuine user detected");

            Admission admission = new Admission();

            admission.setFirstName(admissionDto.getFirstName());
            admission.setLastName(admissionDto.getLastName());
            admission.setEmail(admissionDto.getEmail());
            admission.setMobile(admissionDto.getMobile());
            admission.setCity(admissionDto.getCity());
            admission.setPinCode(admissionDto.getPinCode());
            admission.setStateDistrict(admissionDto.getStateDistrict());
            admission.setLocation(admissionDto.getLocation());
            admission.setCountry(admissionDto.getCountry());

            admissionRepository.save(admission);

        } else {

            System.out.println("Bot detected");

            BotAttempt bot = new BotAttempt();

            bot.setIpAddress(request.getRemoteAddr());
            bot.setCaptchaScore(score);
            bot.setFormData(admissionDto.getEmail());

            botAttemptRepository.save(bot);
        }

        return "redirect:/register?success";
    }
    
    


    @GetMapping("/api/admissions")
    @ResponseBody
    public List<Admission> getAllAdmissions(){

        return admissionRepository.findAll();

    }
    
    
    @GetMapping("/api/bots")
    @ResponseBody
    public List<BotAttempt> getAllBotAttempts(){
    	
    	
    	return botAttemptRepository.findAll();
    } 

}