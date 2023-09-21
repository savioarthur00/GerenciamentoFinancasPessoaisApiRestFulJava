# GerenciamentoFinancasPessoaisApiRestFulJava
Sistema de Gerenciamento de Finanças Pessoais: Aplicativo que ajude os usuários a controlar suas finanças pessoais. Isso pode incluir rastreamento de despesas, categorização de transações e geração de relatórios.

# Diagrama de classe 
```mermaid
classDiagram
  class FinanceManager {
    - users: List<User>
    + addUser(user: User): void
    + removeUser(user: User): void
    + getUsers(): List<User>
  }

  class User {
    - userId: int
    - username: String
    - password: String
    - accounts: List<Account>
    + addAccount(account: Account): void
    + removeAccount(account: Account): void
    + getAccounts(): List<Account>
  }

  class Account {
    - accountId: int
    - accountName: String
    - balance: double
    - transactions: List<Transaction>
    + deposit(amount: double): void
    + withdraw(amount: double): void
    + getTransactions(): List<Transaction>
  }

  class Transaction {
    - transactionId: int
    - date: Date
    - description: String
    - amount: double
    + getTransactionDetails(): String
  }

  FinanceManager --* User : Manages
  User --* Account : Owns
  Account --* Transaction : Contains
```
