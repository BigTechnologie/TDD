package fr.dawan.formationtdd.suites;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

import fr.dawan.formationtdd.FizzBuzzTest;
import fr.dawan.formationtdd.LeapYearTest;
import fr.dawan.formationtdd.ThermometreTest;

// Une suite de test avec Junit 5 -> Une classe sans code  annotée avec @Suite
@Suite
// @SelectClasses -> Permet d'ajouter des classes explicitement à la suite de test
@SelectClasses({ FizzBuzzTest.class, LeapYearTest.class, ThermometreTest.class })
public class SuiteTestClass {

}
