# 🏦 Mortgage Calculator (Java Console App)

> A simple mortgage calculator program that computes monthly and total loan payments  
> based on user input for principal amount, annual interest rate, and loan term.

![Java](https://img.shields.io/badge/Java-17-orange?logo=openjdk)
![Console](https://img.shields.io/badge/Type-Console%20App-blue)
![Maven](https://img.shields.io/badge/Build-Manual%20Execution-lightgrey)

A basic **Java console application** that calculates **monthly** and **total mortgage payments**  
based on user input. The program performs input validation and displays results in currency format.

---

## 🚀 Features
- Accepts **principal amount**, **annual interest rate**, and **loan term** from user input  
- Calculates **monthly** and **total payment** values  
- Validates user inputs with custom error messages  
- Handles invalid inputs via `InputMismatchException` and `IllegalArgumentException`  
- Displays results formatted as currency  

---

## 🧠 How It Works
1. The program asks the user to enter the **principal**, **annual interest rate**, and **term in years**.  
2. It converts the annual interest rate into **monthly rate** and finds the total number of payments.  
3. It applies a standard mortgage calculation method to find the monthly payment.  
4. It then calculates and displays both **monthly** and **total** payment amounts.  

---

## ⚙️ Tech Stack
- Java 17  
- Console I/O (Scanner)  
- Math & NumberFormat classes  

---

## 🧰 How to Run
```bash
javac MortgageCalculator.java
java MortgageCalculator
```
---
## 👨‍💻 Author  
**Yusif Hüseynov**  
*Java Developer | Core Java | Console Applications*  
[GitHub Profile](https://github.com/yusif-hsynv)
