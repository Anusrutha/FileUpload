package com.example.service;

import com.example.model.Customer;
import com.example.repository.CustomerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.nio.charset.StandardCharsets;

@Service
public class CustomerService {
    @Autowired
    private CustomerDTO cdto;
    String line="";
    //create a method to set details
    public void saveCustomerData(){
        try {

            // BufferedReader br to read from the CSV file named "MyProject.csv" located in the  directory.
            // It uses a FileReader to open the file for reading.
            BufferedReader br=new BufferedReader(new FileReader("C:\\Anusrutha\\Training\\JavaFSD\\WorkSpace\\FileUpload\\FileUpload\\src\\main\\resources\\File.csv"));
            //While loop to read the bufferedreader until it reaches null(empty line)
            // Inside the loop, each line of the file is read and stored in the line variable.
             while((line=br.readLine())!=null) {
                String[] data = line.split(",");
                if (data.length >= 4) {
                    // Code to create a Customer object and set its attributes
                    Customer c = new Customer();

                    c.setName(data[0]);
                    c.setIssue(data[1]);
                    c.setIssueID(data[2]);
                    c.setAge(data[3]);
                    // Save the Customer object
                    cdto.save(c);
                } else {
                    System.out.println("Incomplete data" + line);
                }
            }
             //After reading all lines from the file, the BufferedReader is closed to release system resources.
             br.close();
        } catch (IOException e) {
            e.printStackTrace();
            //throw new RuntimeException(e);

        }
    }

}
