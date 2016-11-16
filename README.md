#X12Healthcare v5010X279A1
##ANSI ASC X12 implementation for healthcare

[![Build Status](https://travis-ci.org/xiaoerge/X12Healthcare.svg?branch=master)](https://travis-ci.org/xiaoerge/X12Healthcare)
[![codecov](https://codecov.io/gh/xiaoerge/x12healthcare/branch/master/graph/badge.svg)](https://codecov.io/gh/xiaoerge/x12healthcare)

###Will support parsing and creating of messages such as 837, 835, 277, 270, 271, 999, 997, TA1.

####Note on code coverage
Code coverage will defer until message parsings are done.

####Structure
####270/217
```python
InterchangeEnvelope
    FunctionalGroup
        Transaction
            InformationSource
                InformationReceiver
                    Subscriber
                        Dependent
```

###Progress

####270, 271 (Done)
####835, 837, 277, 999, 997, TA1 (In progress)

#####How to
See unit test for example.
