"""
Line Engine

A class tool to generate ASCI line in output

New in 3.2:
- Better docstring for ease of access.
- New set of class constructors
- Bug Fixes

Newer update will support pattern arguments

Author: Tanzim Ahmed Sagar
Version: 3.2
Date: 10.11.2022
"""

class Liner:
    def __init__(self, lineElement='*', lineLength=80):
        """
        Default constructor
        
        Args:
            lineElement (char): Default line element (default: '*')
            lineLength (int): Default length of the line (default: 80)
        """
        self.lineElement = lineElement
        self.lineLength = lineLength

    def print(self):
        """
        Default method to print a line
        
        Uses the default line element to construct a line with the default length.
        
        Returns:
            str: String representing a line
        """
        line = self.print_with_element(self.lineElement)
        return line

    def print_with_element(self, lineElement):
        """
        Method to print a line that takes a character to construct a line with the default length.
        
        Args:
            lineElement (char): Character that will construct the line
        
        Returns:
            str: String representing a line
        """
        line = self.print_with_length(lineElement, self.lineLength)
        return line

    def print_with_length(self, lineLength):
        """
        Method to print a line that takes an integer to construct a line of that length
        with the default line element.
        
        Args:
            lineLength (int): Length of the line
        
        Returns:
            str: String representing a line
        """
        line = self.print_with_element(self.lineElement, lineLength)
        return line

    def print_with_element_and_length(self, lineElement, lineLength):
        """
        Method to print a line that takes a character to construct a line
        with the given length.
        
        Args:
            lineElement (char): Character that will construct the line
            lineLength (int): Length of the line
        
        Returns:
            str: String representing a line
        """
        line = ""
        for i in range(lineLength):
            line += lineElement
        return line

    def pattern(self, pattern, mode, lineLength):
        """
        Method to generate a line using a given pattern, mode, and line length.
        
        Args:
            pattern (str): The pattern for the line, as a string.
            mode (char): The mode to use for generating the line, as a char.
            lineLength (int): The desired length of the generated line.
        
        Returns:
            str: The generated line as a string.
        """
        line = ""
        if mode == 'F':
            patternIndex = 0
            while len(line) < lineLength:
                line += pattern[patternIndex]
                patternIndex += 1
                if patternIndex == len(pattern):
                    patternIndex = 0
        elif mode == 'S':
            stretch = len(pattern) - (lineLength % len(pattern))
            for i in range(len(pattern)):
                for j in range(stretch):
                    line += pattern[i]
        elif mode == 'C':
            border = (lineLength // 2) - (len(pattern) // 2)
            for i in range(border):
                line += pattern[0]
            line += pattern
            for i in range(border):
                line += pattern[-1]
        return line
