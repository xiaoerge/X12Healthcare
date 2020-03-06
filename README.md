# X12Healthcare v5010
## ANSI ASC X12 implementation for healthcare

[![Build Status](https://travis-ci.org/xiaoerge/X12Healthcare.svg?branch=master)](https://travis-ci.org/xiaoerge/X12Healthcare)
[![codecov](https://codecov.io/gh/xiaoerge/x12healthcare/branch/master/graph/badge.svg)](https://codecov.io/gh/xiaoerge/x12healthcare)

## Update. Will probably resume working at some point. No longer at a healthcare IT company.
## ~~Development is on hold. Working out an IP issue.~~

### Will support parsing and creating of messages such as 837, 835, 277, 270, 271, 999, 997, TA1.

## Important license information
Read license.txt

#### Note on code coverage
Code coverage will defer until message parsings are done.

#### Message Structure
```python
InterchangeEnvelope
    FunctionalGroup
        Transaction
            InformationSource
                InformationReceiver
                    Subscriber
                        Dependent
```

### Progress
### #Done - 270, 271
#### In Progress - 835, 837
#### On Roadmap - 277, 999, 997, TA1

#### How to use
See unit test for examples

#### Bug report
Use Github issue tracker
