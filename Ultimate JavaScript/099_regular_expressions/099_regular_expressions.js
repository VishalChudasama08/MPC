// http://regexr.com for more in regular expressions

// on string you match any type of pattern (yes, any any pattern any, type of text) using regular expressions

// ex. if you match like -> ( new line start with "0" number and "a" caracter) on big paragraph, then this possible using regular expression

const regux = /very/g; // this is regular expressions
const string = "Vishal is very very very nice aawesome nice very very good boy";
// const text = string.replace(any, "VERY");  // if use this line than only first 'very' is replace In 'VERY'
const text = string.replace(regux, "VERY"); // useing regux variable to replace all 'very' in 'VERY'
console.log(text);

/* 

1. / and /g
    /: This is the start and end delimiter for the regular expression in JavaScript. Everything between the two slashes defines the pattern.
    g: This is a global flag. It means that the regex should search for all matches in the string, not just the first one.
2. [^...]
    [^...]: The caret (^) inside square brackets means "negation" in this context. It matches any character not specified inside the brackets. So, for example, [^a-z] would match any character except lowercase letters a to z.
3. a-zA-Z0-9
    a-z: Matches any lowercase letter from a to z.
    A-Z: Matches any uppercase letter from A to Z.
    0-9: Matches any digit from 0 to 9.
    Together, [a-zA-Z0-9] matches any alphanumeric character (letters and numbers).

4. \s
    \s: This matches any whitespace character, such as spaces, tabs, or newline characters. It includes:
    Space ( )
    whitespace (\s)
    Tab (\t)
    Newline (\n)
    Carriage return (\r)
    Form feed (\f)

5. Putting it all together: /[^a-zA-Z0-9\s]/g
    [^a-zA-Z0-9\s]: This part matches any character that is NOT a letter (either uppercase or lowercase), a number, or a whitespace character.
    g: The global flag means the regex will find all such matches in the string, not just the first one.

Regex Variations:
    /[a-zA-Z]/: Matches any letter (upper or lower case).
    /\d/: Matches any digit (equivalent to [0-9]).
    /\W/: Matches any non-word character (equivalent to [^a-zA-Z0-9_]).
    /\s/: Matches any whitespace character.
    /[^aeiou]/: Matches any character that is not a vowel (excluding a, e, i, o, u).

Key Regex Metacharacters:
    ^: Matches the start of a string (inside brackets [ ], it negates the match).
    $: Matches the end of a string.
    .: Matches any single character except newline.
    *: Matches 0 or more of the preceding element.
    +: Matches 1 or more of the preceding element.
    ?: Matches 0 or 1 of the preceding element.
    \d: Matches any digit (0-9).
    \D: Matches any non-digit character.
    \w: Matches any word character (letters, digits, and underscore _).
    \W: Matches any non-word character.
    \b: Matches a word boundary.
    \B: Matches a non-word boundary.

*/