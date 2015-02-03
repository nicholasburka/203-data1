JFLAGS = -g
JC = javac
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
	FiniteSet.java \
	BSTNode.java \
	BSTree.java \
	Branch.java \
	Leaf.java \
	Tester.java 

default: classes

classes: $(CLASSES:.java=.class)

clean:
	$(RM) *.class