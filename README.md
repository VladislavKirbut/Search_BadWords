 🟢
– Create a BlrPassport class, describing the data of the Belarusian passport.
– The last name in Latin, first name in Latin, gender, date of birth, passport number, identification number, date of issue, expiration date (date) are stored in the class
– Perform data validation inside the constructor. Fall with an error if the data is invalid
– Passport number: two characters from the suggested ones (AB, BM, HB, KH, MP, MC, KB, PP, SP, DP), 7 digits. Check using regular expressions
– Identification number: 7 digits, letter from the proposed (A, B, C, K, E, M, H), 3 digits, 2 letters from the proposed (PB, BA, BI), 1 digit. Checking with regular expressions
– Date of issue before the expiration date
– Declare a toString method that returns a string representation of data in a free format
– Declare the boolean isExpired(LocalDate now) method, which checks whether the passport is expired. On the calling side, we pass the argument LocalDate.now(ZoneId.of("Europe/Minsk"))

 🟡
– Create a TextBlackListFilter class.
– The class constructor must accept an array of strings – a set of unacceptable words and expressions.
– Declare a method that accepts some text (let's say a user comment) and returns whether it contains unacceptable words
– Declare a method that accepts some text and returns how many unacceptable words it contains
– Declare a method that accepts some text and returns a modified text where unacceptable words are replaced with the string “####”
– Stand-alone words should be searched, not substrings
– Unacceptable expressions should be searched case-insensitive
– Unacceptable expressions may contain any Unicode characters
– The text may contain line breaks

– In a separate class, write a demonstration of the work of the class
– Unacceptable words to request from the user via the console. The user enters the list of words as a single line, separating the words with commas (possibly with spaces). To cast such a string to an array, use the split(...) method of the String class. For example, from “word1, word2, word word word3” should be an array {“word1”, “word2”, “word word word3"}
– Create a single TextBlackListFilter object to demonstrate its methods. Arguments are requested from the user from the console
