# Time Deposit Refactoring Kata
## XA bank time deposit

It's unfortunate that the junior developer has left the company without handing his work over to anyone. And what is even more unfortunate is that you have been assigned to take over the code that he left behind. 

We were able to savage only a portion of the business requirements, but we're not sure if the existing implementation has covered all the flows.

- The system should calculate the monthly interest based on the account type.
- No interest will be added to any time deposit plans for the first 30 days. 
- There are 4 types of time deposit plans available within the bank: basic, student, premium, and internal
  - basic plan: 1%
  - student plan: 3%
  - premium plan: 5%
  - internal(employee) plan: 10%
- Aside from the internal plan, which follows an auto-renewal strategy, all existing time deposit plans should be terminated after 1 year. After the plan is terminated, the balance of the time deposit account should become 0 as the funds will automatically be transferred to their savings account. 

We'd like for you to refactor the solution and ensure that the implementation meets all of the above requirements. As the code is already running on production, please ensure that no existing functionalities are broken.

Limitations: 
- You may not add any additional methods (including getters and setters) to the TimeDeposit class
- You may not modify the calculateInterest method signature