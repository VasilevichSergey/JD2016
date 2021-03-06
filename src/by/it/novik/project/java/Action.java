package by.it.novik.project.java;


enum Action {
    REGISTRATION {
        {
            this.command = new CommandRegistration();
            this.inPage="/reg.jsp";
            this.okPage ="/index.jsp";
        }
    },
    LOGIN {
        {
            this.command = new CommandLogin();
            this.inPage="/index.jsp";
            this.okPage ="/profile.jsp";
        }
    },
    LOGOUT {
        {
            this.command = new CommandLogout();
            this.inPage="/logout.jsp";
            this.okPage ="/index.jsp";

        }
    },
    ACCOUNTS {
        {
            this.command = new CommandGetAccounts();
            this.inPage="/accounts.jsp";
            this.okPage ="/accounts.jsp";
        }
    },
    PROFILE {
        {
            this.command = new CommandProfile();
            this.inPage="/profile.jsp";
        }
    },
    NEW_ACCOUNT {
        {
            this.command = new CommandCreateAccount();
            this.inPage="/accounts.jsp";
            this.okPage ="/accounts.jsp";
        }
    },
    PAYMENTS {
        {
            this.command = new CommandGetPayments();
            this.inPage="/payments.jsp";
            //this.okPage ="/index.jsp";
        }
    },
    PAY {
        {
            this.command = new CommandPay();
            this.inPage="/pay.jsp";
            this.okPage ="/payments.jsp";
        }
    },
    REFILL {
        {
            this.command = new CommandRefilling();
            this.inPage="/refill.jsp";
            this.okPage ="/do?command=Accounts";
        }
    },
    BLOCK {
        {
            this.command = new CommandBlocking();
            this.inPage="/block.jsp";
            this.okPage ="/accounts.jsp";
        }
    },
    ERROR {
        {
            this.command = new CommandLogout();
        }
    };
    public String inPage="/error.jsp";
    public String okPage ="/error.jsp";
    public ActionCommand command;

    public ActionCommand getCurrentCommand() {
        return command;
    }

    public static final String msgError="msg_error";
    public static final String msgMessage="message";

}