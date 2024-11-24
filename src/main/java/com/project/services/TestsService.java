package com.project.services;

import com.project.dto.TestRequestDTO;
import com.project.models.AnswersModel;
import com.project.models.QuestionsModel;
import com.project.models.TestsModel;
import com.project.repositories.AnswersRepository;
import com.project.repositories.QuestionsRepository;
import com.project.repositories.TestsRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;


@Service
public class TestsService {

    @Autowired
    private TestsRepository testsRepository;

   @Autowired
    private QuestionsRepository questionsRepository;
    
    @Autowired
    private AnswersRepository answersRepository;

     @Transactional
    public TestRequestDTO saveCompleteTest(TestRequestDTO testDTO) {
        System.out.println("Iniciando guardado de test para compañía ID: " + testDTO.getId_empresa());
        try {
            TestsModel test = new TestsModel();
            
            test.setCompanyId(Integer.parseInt(testDTO.getId_empresa()));
            System.out.println("Guardando test en la base de datos...");
            test.setDate(new Date());
            test = testsRepository.save(test);
            System.out.println("Test guardado con ID: " + test.getId());

            // Guardar preguntas y respuestas
            saveQuestionAndAnswer(test.getId(), 1, "Pregunta 1", testDTO.getPregunta1());
            saveQuestionAndAnswer(test.getId(), 2, "Pregunta 2", testDTO.getPregunta2());
            saveQuestionAndAnswer(test.getId(), 3, "Pregunta 3", testDTO.getPregunta3());
            saveQuestionAndAnswer(test.getId(), 4, "Pregunta 4", testDTO.getPregunta4());
            saveQuestionAndAnswer(test.getId(), 5, "Pregunta 5", testDTO.getPregunta5());
            saveQuestionAndAnswer(test.getId(), 6, "Pregunta 6", testDTO.getPregunta6());
            saveQuestionAndAnswer(test.getId(), 7, "Pregunta 7", testDTO.getPregunta7());
            saveQuestionAndAnswer(test.getId(), 8, "Pregunta 8", testDTO.getPregunta8());
            saveQuestionAndAnswer(test.getId(), 9, "Pregunta 9", testDTO.getPregunta9());

            return testDTO;
        } catch (Exception e) {
            System.err.println("Error guardando test: " + e.getMessage());
            
            throw e;
        }
    }

    @Transactional
    public TestRequestDTO updateCompleteTest(String companyId, TestRequestDTO testDTO) {
        System.out.println("Iniciando updateCompleteTest para companyId: " + companyId);
        try {
            TestsModel test = testsRepository.findByCompanyId(Integer.parseInt(companyId))
                .orElseThrow(() -> new RuntimeException("Test not found for company: " + companyId));
            
            test.setDate(new Date());
            testsRepository.save(test);

            List<QuestionsModel> questions = questionsRepository.findByTestId(test.getId());
            
            if (questions.size() != 9) {
                throw new RuntimeException("Invalid number of questions found");
            }

            // Actualizar respuestas
            for (int i = 0; i < questions.size(); i++) {
                QuestionsModel question = questions.get(i);
                AnswersModel answer = answersRepository.findByQuestionId(question.getId())
                    .orElseThrow(() -> new RuntimeException("Answer not found for question: " + question.getId()));
                
                String newAnswer = switch (i + 1) {
                    case 1 -> testDTO.getPregunta1();
                    case 2 -> testDTO.getPregunta2();
                    case 3 -> testDTO.getPregunta3();
                    case 4 -> testDTO.getPregunta4();
                    case 5 -> testDTO.getPregunta5();
                    case 6 -> testDTO.getPregunta6();
                    case 7 -> testDTO.getPregunta7();
                    case 8 -> testDTO.getPregunta8();
                    case 9 -> testDTO.getPregunta9();
                    default -> throw new RuntimeException("Invalid question number");
                };
                
                answer.setAnswer(newAnswer);
                answersRepository.save(answer);
            }

            return testDTO;
        } catch (Exception e) {
            System.err.println("Error en updateCompleteTest: " + e.getMessage());
            throw e;
        }
    }

    private void saveQuestionAndAnswer(Integer testId, Integer questionNumber, String questionText, String answer) {
        try {
            QuestionsModel question = new QuestionsModel();
            question.setTestId(testId);
            question.setQuestion(questionText);
            question = questionsRepository.save(question);

            AnswersModel answerModel = new AnswersModel();
            answerModel.setQuestionId(question.getId());
            answerModel.setAnswer(answer);
            answersRepository.save(answerModel);
            
            System.out.println("Pregunta " + questionNumber + " y respuesta guardadas exitosamente");
        } catch (Exception e) {
            System.err.println("Error guardando pregunta/respuesta " + questionNumber + ": " + e.getMessage());
            throw e;
        }
    }

    public TestRequestDTO getTestWithAnswersByCompanyId(String companyId) {
        System.out.println("Buscando test para companyId: " + companyId);
        try {
            TestsModel test = testsRepository.findByCompanyId(Integer.parseInt(companyId))
                .orElseThrow(() -> new RuntimeException("Test not found"));

            List<QuestionsModel> questions = questionsRepository.findByTestId(test.getId());
            TestRequestDTO dto = new TestRequestDTO();
            dto.setId_empresa(companyId);

            for (QuestionsModel question : questions) {
                AnswersModel answer = answersRepository.findByQuestionId(question.getId())
                    .orElseThrow(() -> new RuntimeException("Answer not found"));
                
                int index = questions.indexOf(question) + 1;
                switch(index) {
                    case 1 -> dto.setPregunta1(answer.getAnswer());
                    case 2 -> dto.setPregunta2(answer.getAnswer());
                    case 3 -> dto.setPregunta3(answer.getAnswer());
                    case 4 -> dto.setPregunta4(answer.getAnswer());
                    case 5 -> dto.setPregunta5(answer.getAnswer());
                    case 6 -> dto.setPregunta6(answer.getAnswer());
                    case 7 -> dto.setPregunta7(answer.getAnswer());
                    case 8 -> dto.setPregunta8(answer.getAnswer());
                    case 9 -> dto.setPregunta9(answer.getAnswer());
                }
            }

            return dto;
        } catch (Exception e) {
            System.err.println("Error en getTestWithAnswersByCompanyId: " + e.getMessage());
            throw e;
        }
    }
}
