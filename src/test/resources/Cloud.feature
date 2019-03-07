Feature: Email estimation from Google cloud

  Background:
    Given I opened Google Cloud Platform Pricing Calculator

  Scenario Outline: Estimate pricing
    When I fill the form with parameters:
      | Number of instance | Operation System                                                | VM Class | Instance type                           | Number of GPUs | GPU type          | SSD      | Datacenter location      | Commited usage |
      | 4                  | Free: Debian, CentOS, CoreOS, Ubuntu, or other User Provided OS | Regular  | n1-standard-8    (vCPUs: 8, RAM: 30 GB) | 1              | NVIDIA Tesla V100 | 2x375 GB | Frankfurt (europe-west3) | 1 Year         |
    And I added this form to estimate
    Then Input and estimated data match
    And Total cost is USD <cost>

    Examples:
      | cost     |
      | 1,187.77 |