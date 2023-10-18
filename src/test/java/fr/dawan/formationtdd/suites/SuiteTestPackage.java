package fr.dawan.formationtdd.suites;

import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;

@Suite
// @SelectPackages permet de sélectionner les classes des packages sélectionnées 
@SelectPackages({ "fr.dawan.formationtdd.test1", "fr.dawan.formationtdd.test2" })
public class SuiteTestPackage {

}
