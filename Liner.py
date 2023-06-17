"""
Line Engine
-----------
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
        self.lineElement = lineElement
        self.lineLength = lineLength

    def print_line(self):
        """
        Default method to print a line.
        Uses default character to construct a line with the default length.
        
        Returns:
            str: String representing a line
        """
        line = self.print_line_char(self.lineElement)
        return line

    def print_line_char(self, lineElement):
        """
        Method to print a line that takes a character to construct a line with the default length.
        
        Args:
            lineElement (char): Character that'll construct the line
            
        Returns:
            str: String representing a line
        """
        line = self.print_line_char_length(lineElement, self.lineLength)
        return line

    def print_line_length(self, lineLength):
        """
        Method to print a line that takes an integer to construct a line of that length with the default character element.
        
        Args:
            lineLength (int): Length of the line
            
        Returns:
            str: String representing a line
        """
        line = self.print_line_char_length(self.lineElement, lineLength)
        return line

    def print_line_char_length(self, lineElement, lineLength):
        """
        Method to print a line that takes a character to construct a line with the given length in integer.
        
        Args:
            lineElement (char): Character that'll construct the line
            lineLength (int): Length of the line
            
        Returns:
            str: String representing a line
        """
        line = ""
        for i in range(lineLength):
            line += lineElement
        return line
