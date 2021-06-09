package com.example.resister;


import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/registers")
public class RegisterApi {
    private RegisterRepository registerRepository;
    public  RegisterApi(RegisterRepository registerRepository){this.registerRepository=registerRepository;}
  
  @GetMapping()
  public List<Register> getResisters() {
      List<Register>  registers = new ArrayList<>();
      for (Register register : registerRepository.findAll()) {
          registers.add(register);
      }

      return registers;
  }
    @GetMapping("/{id}")
    public Register getRegisterInformation(@PathVariable("id") String id) {
       Register register = registerRepository.findById(Integer.valueOf(id)).get();
        return register;
    }

    @PostMapping()
    public void addRegister(@RequestBody Register register) {
        registerRepository.save(register);
    }

    @PutMapping()
    public void updateRegister(@RequestBody Register register) {
        registerRepository.save(register);
    }

    @DeleteMapping()
    public void deleteStudent(@RequestBody Register register) {
        registerRepository.delete(register);
    }



}
