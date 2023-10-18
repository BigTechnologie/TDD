package fr.dawan.formationtdd.suites;

import org.junit.platform.suite.api.IncludeClassNamePatterns;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectPackages("fr.dawan.formationtdd")
// @IncludeClassNamePatterns -> inclure les classes qui correspondent à l'expression réguliaire
@IncludeClassNamePatterns("^.*metreTest?$")
public class SuiteTestClassNamePattern {

}
