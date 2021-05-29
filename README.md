# long-programming-language
WIP esotheric language based on the length of each line

## What works as of (hopefully) latest commit
Anything considered "code" is differentiated by the number of characters between each spaces. Anything between `""` or `''` is an exception because it's a string.

Example:
`a "foo"` is the same as `b "foo"`

Each command goes in a different line. Anything exceeding the number of parameters for each command is not considered code.
Example:
`p "foo" this is text, it might as well be a comment`

### Asigning a variable
As of now, a variable is always considered a string. This is subject to change.

Each variable is identified by the number of characters of its identifier.

`** * "foo"`

This will asign the value `foo` to a variable of id 1. This variable can later be accesed with `a` or with `b`, for example.

### Console printing
You can print a String or a variable:

`* "foo"`

```
** aaa "foo"
* ***
```
